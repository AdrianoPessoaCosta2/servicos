package apcmmi.servicos.service;

import apcmmi.servicos.domain.Servico;
import apcmmi.servicos.repository.ServicosRepository;
import apcmmi.servicos.requests.ServicoPostRequestBody;
import apcmmi.servicos.requests.ServicoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ServicosService {

    private final ServicosRepository servicosRepository;
    public List<Servico> listAll() {
        return servicosRepository.findAll();
    }

    public Servico findById(long id) {
        return servicosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço não encontrado"));
    }

    public Servico save(ServicoPostRequestBody servicoPostRequestBody) {
        return servicosRepository.save(Servico.builder().name(servicoPostRequestBody.getName()).build());
    }

    public void delete(long id) {
        servicosRepository.delete(findById(id));
    }

    public void replace(ServicoPutRequestBody servicoPutRequestBody) {
        Servico savedServico = findByIdOrThrowBadRequestException(servicoPutRequestBody.getId());
        Servico servico = Servico.builder()
                .id(savedServico.getId())
                .name(servicoPutRequestBody.getName())
                .build();
        servicosRepository.save(servico);
    }

    private Servico findByIdOrThrowBadRequestException(Long id) {
        return servicosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço não encontrado"));
    }
}
