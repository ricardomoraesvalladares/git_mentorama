package br.com.hospital.hospital.Controller;

import br.com.hospital.hospital.DTO.InternacaoDto;
import br.com.hospital.hospital.DTO.ResultadosConsultasDto;
import br.com.hospital.hospital.Entity.Internacao;
import br.com.hospital.hospital.Repository.InternacaoRepository;
import br.com.hospital.hospital.Repository.PacienteRepository;
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
@RequestMapping("/internacao")
public class InternacaoController{

    @Autowired
    InternacaoRepository internacaoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ProfissionalRepository profissionalRepository;

    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @GetMapping
    @RolesAllowed({"user", "admin"})
    public ResponseEntity<List<InternacaoDto>> listaInternacoes(){

        List<Internacao> internacoes = internacaoRepository.findAll();
        List<InternacaoDto> internacaoListDTO = new ArrayList<>();
        internacoes.forEach(internacao -> internacaoListDTO.add
                (IServiceHospital.converteParaInternacaoDTO(internacao)));

        if(internacaoListDTO.isEmpty()){
            logger.info("Não existem internações cadastradas !!!");
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(internacaoListDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/pacienteMaisInternacao")
    @RolesAllowed({"user", "admin"})
    public ResponseEntity<List<ResultadosConsultasDto>> listaPacientesMaisInternacao(){
        List<String> resultados = internacaoRepository.listaPacientesComMaisInternacoes();
        List<ResultadosConsultasDto> pacienteMaisInternacao = new ArrayList<>();
        resultados.forEach(resultado -> pacienteMaisInternacao.add(IServiceHospital.converteStringParaObjeto(resultado)));

        return new ResponseEntity<>(pacienteMaisInternacao, HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Internacao> adicionaInternacao(@RequestBody InternacaoDto internacaoDto){
        try{
            Internacao novaInternacao = new Internacao();
            novaInternacao.setDataEntrada(internacaoDto.getDataEntrada());
            novaInternacao.setDataSaida(internacaoDto.getDataSaida());
            novaInternacao.setDiagnostico(internacaoDto.getDiagnostico());
            novaInternacao.setPaciente(pacienteRepository.
                    findById(internacaoDto.getPaciente().getId()).orElse(null));
            novaInternacao.setProfissional(profissionalRepository.
                    findById(internacaoDto.getProfissional().getMatricula()).orElse(null));
            internacaoRepository.save(novaInternacao);
            return new ResponseEntity<>(novaInternacao, HttpStatus.OK);
        }catch(RuntimeException e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("admin")
    public ResponseEntity removeInternacao(@PathVariable("id") Long id){
        if(internacaoRepository.existsById(id)){
            internacaoRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            logger.error("Internação não encontrada !!!");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @RolesAllowed("admin")
    public ResponseEntity<Internacao> atualizaInternacao(@RequestBody InternacaoDto internacaoDto){
        if(internacaoRepository.existsById(internacaoDto.getId())){
            Internacao internacaoAtualizada = new Internacao();
            internacaoAtualizada.setDataEntrada(internacaoDto.getDataEntrada());
            internacaoAtualizada.setDataSaida(internacaoDto.getDataSaida());
            internacaoAtualizada.setDiagnostico(internacaoDto.getDiagnostico());
            internacaoAtualizada.setPaciente(pacienteRepository.findById
                    (internacaoDto.getPaciente().getId()).orElse(null));
            internacaoAtualizada.setProfissional(profissionalRepository.findById
                    (internacaoDto.getProfissional().getMatricula()).orElse(null));
            internacaoRepository.save(internacaoAtualizada);
            return new ResponseEntity<>(internacaoAtualizada, HttpStatus.OK);
        }else{
            logger.error("Internação não cadastrada, não pode ser atualizada !!!");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
