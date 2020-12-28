package apcmmi.servicos.controller;

import apcmmi.servicos.domain.Servico;
import apcmmi.servicos.service.ServicosService;
import apcmmi.servicos.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("servicos")
@Log4j2
@RequiredArgsConstructor
public class ServicoController {
    private final DateUtil dateUtil;
    private final ServicosService servicosService;

    @GetMapping
    public ResponseEntity<List<Servico>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabasStyle(LocalDateTime.now()));
        return ResponseEntity.ok(servicosService.listAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabasStyle(LocalDateTime.now()));
        return ResponseEntity.ok(servicosService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico servico){
        return new ResponseEntity<>(servicosService.save(servico), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        servicosService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Servico servico){
        servicosService.replace(servico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
