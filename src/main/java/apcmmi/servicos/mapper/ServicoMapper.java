package apcmmi.servicos.mapper;

import apcmmi.servicos.domain.Servico;
import apcmmi.servicos.requests.ServicoPostRequestBody;
import apcmmi.servicos.requests.ServicoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ServicoMapper {
    public static final ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);
    public abstract Servico toServico(ServicoPostRequestBody servicoPostRequestBody);

    public abstract Servico toServico(ServicoPutRequestBody servicoPutRequestBody);

}
