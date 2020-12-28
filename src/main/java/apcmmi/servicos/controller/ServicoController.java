package apcmmi.servicos.controller;

import apcmmi.servicos.domain.Servico;
import apcmmi.servicos.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("servico")
@Log4j2
@RequiredArgsConstructor
public class ServicoController {
    private final DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Servico> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabasStyle(LocalDateTime.now()));
        return List.of(new Servico("Preventiva"), new Servico("Corretiva"));
    }
}
