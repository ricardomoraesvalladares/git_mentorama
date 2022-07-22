package br.com.hospital.hospital.Controller;

import br.com.hospital.hospital.DTO.ResultadosConsultasDto;
import br.com.hospital.hospital.Entity.Profissional;
import br.com.hospital.hospital.Repository.ProfissionalRepository;
import br.com.hospital.hospital.Service.IServiceHospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProfissionalController.class);

    @GetMapping
    @RolesAllowed({"user", "admin"})
    public ResponseEntity<List<Profissional>> listaProfissionais(){
        List<Profissional> profissionais = profissionalRepository.findAll();
        if(profissionais.isEmpty()){
            logger.info("Não existem profissionais cadastrados !!!");
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(profissionais, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/maisMedicos")
    @RolesAllowed({"user", "admin"})
    public ResponseEntity<List<ResultadosConsultasDto>> listaDepartamentoMaisMedicos(){
        List<String> resultados = profissionalRepository.listaDepartamentosComMaiorQuantidadeMedicos();
        List<ResultadosConsultasDto> departamentoMaiorQtdMedicos = new ArrayList<>();
        for(String resultado : resultados){
            departamentoMaiorQtdMedicos.add(IServiceHospital.converteStringParaObjeto(resultado));
        }
        return new ResponseEntity<List<ResultadosConsultasDto>>(departamentoMaiorQtdMedicos, HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Profissional> adicionaProfissional(@RequestBody Profissional profissional){
        try{
            profissionalRepository.save(profissional);
            return new ResponseEntity<>(profissional, HttpStatus.OK);
        }catch(RuntimeException e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("admin")
    public ResponseEntity removeProfissional(@PathVariable("id") Long id){
        if(profissionalRepository.existsById(id)){
            profissionalRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            logger.error("Profissional não encontrado!!!");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @RolesAllowed("admin")
    public ResponseEntity<Profissional> atualizaProfissional(@RequestBody Profissional profissional){
        if(profissionalRepository.existsById(profissional.getMatricula())){
            profissionalRepository.save(profissional);
            return new ResponseEntity<>(profissional, HttpStatus.OK);
        }else{
            logger.error("Profissional não cadastrado, não pode ser atualizado !!!");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
