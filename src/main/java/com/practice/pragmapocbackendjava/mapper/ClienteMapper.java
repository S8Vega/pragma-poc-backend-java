package com.practice.pragmapocbackendjava.mapper;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
            @Mapping(target = ClienteDto.Atributos.NOMBRES, source = "cliente." + ClienteEntity.Atributos.NOMBRES),
            @Mapping(target = ClienteDto.Atributos.APELLIDOS, source = "cliente." + ClienteEntity.Atributos.APELLIDOS),
            @Mapping(target = ClienteDto.Atributos.TIPO_IDENTIFICACION, source = "identificacion." + IdentificacionEntity.Atributos.TIPO),
            @Mapping(target = ClienteDto.Atributos.NUMERO_IDENTIFICACION, source = "identificacion." + IdentificacionEntity.Atributos.NUMERO),
            @Mapping(target = ClienteDto.Atributos.EDAD, source = "cliente." + ClienteEntity.Atributos.EDAD),
            @Mapping(target = ClienteDto.Atributos.CIUDAD_DE_NACIMIENTO, source = "ciudad." + CiudadEntity.Atributos.NOMBRE),
            @Mapping(target = ClienteDto.Atributos.FOTO, source = "foto." + FotoEntity.Atributos.BASE64)
    })
    ClienteDto toClienteDto(CiudadEntity ciudad, ClienteEntity cliente,
                            FotoEntity foto, IdentificacionEntity identificacion);

    ClienteEntity toClienteEntity(ClienteDto cliente);

    @Mapping(target = CiudadEntity.Atributos.NOMBRE, source = "ciudad." + ClienteDto.Atributos.CIUDAD_DE_NACIMIENTO)
    CiudadEntity toCiudadEntity(ClienteDto cliente);

    @Mapping(target = FotoEntity.Atributos.BASE64, source = "cliente." + ClienteDto.Atributos.FOTO)
    FotoEntity toFotoEntity(ClienteDto cliente);

    @Mapping(target = IdentificacionEntity.Atributos.TIPO, source = "cliente." + ClienteDto.Atributos.TIPO_IDENTIFICACION)
    @Mapping(target = IdentificacionEntity.Atributos.NUMERO, source = "cliente." + ClienteDto.Atributos.NUMERO_IDENTIFICACION)
    IdentificacionEntity toIdentificacionEntity(ClienteDto cliente);
}
