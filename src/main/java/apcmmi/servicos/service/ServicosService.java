package apcmmi.servicos.service;

import apcmmi.servicos.domain.Servico;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ServicosService {

    private static List<Servico> servicos;

    static{
        servicos = new ArrayList<>(List.of(new Servico(1L, "Preventiva"), new Servico(2L, "Corretiva")));
    }

    public List<Servico> listAll() {
        return servicos;
    }

    public Servico findById(long id) {
        return servicos.stream()
                .filter(servico -> servico.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço não encontrado!"));
    }

    public Servico save(Servico servico) {
        servico.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        servicos.add(servico);
        return servico;
    }

    public void delete(long id) {
        servicos.remove(findById(id));
    }

    public void replace(Servico servico) {
        delete(servico.getId());
        servicos.add(servico);
    }
}
