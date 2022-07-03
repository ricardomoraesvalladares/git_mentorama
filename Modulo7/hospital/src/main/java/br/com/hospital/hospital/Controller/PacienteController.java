package br.com.hospital.hospital.Controller;

import br.com.hospital.hospital.Entity.Paciente;
import br.com.hospital.hospital.Repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @GetMapping
    public ResponseEntity<List<Paciente>> listaPacientes(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        if(pacientes.isEmpty()){
            logger.info("Não existem pacientes cadastrados !!!");
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(pacientes, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> adicionaPaciente(@RequestBody Paciente paciente){
        try {
            Paciente novoPaciente = pacienteRepository.save(paciente);
            return new ResponseEntity<>(novoPaciente, HttpStatus.OK);
        }catch(RuntimeException e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removePaciente(@PathVariable("id") Long id){
        if(pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            logger.error("Paciente não encontrado !!!");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizaPaciente(@RequestBody Paciente paciente){
        if(pacienteRepository.existsById(paciente.getId())) {
            pacienteRepository.save(paciente);
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }else {
            logger.error("Paciente não cadastrado, não pode ser atualizado !!!");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
