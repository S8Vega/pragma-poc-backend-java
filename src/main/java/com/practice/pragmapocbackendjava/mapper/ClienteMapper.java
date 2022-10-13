package com.practice.pragmapocbackendjava.mapper;

import com.practice.pragmapocbackendjava.dto.ClienteDto;
import com.practice.pragmapocbackendjava.entity.CiudadEntity;
import com.practice.pragmapocbackendjava.entity.ClienteEntity;
import com.practice.pragmapocbackendjava.entity.FotoEntity;
import com.practice.pragmapocbackendjava.entity.IdentificacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = ClienteDto.Atributos.NOMBRES, source = "cliente." + ClienteEntity.Atributos.NOMBRES)
    @Mapping(target = ClienteDto.Atributos.APELLIDOS, source = "cliente." + ClienteEntity.Atributos.APELLIDOS)
    @Mapping(target = ClienteDto.Atributos.TIPO_IDENTIFICACION, source = "identificacion." + IdentificacionEntity.Atributos.TIPO)
    @Mapping(target = ClienteDto.Atributos.NUMERO_IDENTIFICACION, source = "identificacion." + IdentificacionEntity.Atributos.NUMERO)
    @Mapping(target = ClienteDto.Atributos.EDAD, source = "cliente." + ClienteEntity.Atributos.EDAD)
    @Mapping(target = ClienteDto.Atributos.CIUDAD_DE_NACIMIENTO, source = "ciudad." + CiudadEntity.Atributos.NOMBRE)
    @Mapping(target = ClienteDto.Atributos.FOTO, source = "foto." + FotoEntity.Atributos.BASE64)
    ClienteDto toClienteDto(CiudadEntity ciudad, ClienteEntity cliente,
                            FotoEntity foto, IdentificacionEntity identificacion);

    @Mapping(target = ClienteEntity.Atributos.ID, ignore = true)
    @Mapping(target = ClienteEntity.Atributos.IDENTIFICACION, ignore = true)
    @Mapping(target = ClienteEntity.Atributos.NOMBRES, source = "cliente." + ClienteDto.Atributos.NOMBRES)
    @Mapping(target = ClienteEntity.Atributos.APELLIDOS, source = "cliente." + ClienteDto.Atributos.APELLIDOS)
    @Mapping(target = ClienteEntity.Atributos.EDAD, source = "cliente." + ClienteDto.Atributos.EDAD)
    @Mapping(target = ClienteEntity.Atributos.CIUDAD_DE_NACIMIENTO, source = "ciudad")
    @Mapping(target = ClienteEntity.Atributos.FOTO, ignore = true)
    ClienteEntity toClienteEntity(ClienteDto cliente, CiudadEntity ciudad);

    @Mapping(target = CiudadEntity.Atributos.NOMBRE, source = "cliente." + ClienteDto.Atributos.CIUDAD_DE_NACIMIENTO)
    @Mapping(target = CiudadEntity.Atributos.ID, ignore = true)
    @Mapping(target = CiudadEntity.Atributos.CLIENTES, ignore = true)
    CiudadEntity toCiudadEntity(ClienteDto cliente);

    @Mapping(target = FotoEntity.Atributos.BASE64, source = "cliente." + ClienteDto.Atributos.FOTO)
    @Mapping(target = FotoEntity.Atributos.ID, ignore = true)
    @Mapping(target = FotoEntity.Atributos.CLIENTE, source = "entity")
    FotoEntity toFotoEntity(ClienteDto cliente, ClienteEntity entity);

    @Mapping(target = IdentificacionEntity.Atributos.TIPO, source = "cliente." + ClienteDto.Atributos.TIPO_IDENTIFICACION)
    @Mapping(target = IdentificacionEntity.Atributos.NUMERO, source = "cliente." + ClienteDto.Atributos.NUMERO_IDENTIFICACION)
    @Mapping(target = IdentificacionEntity.Atributos.ID, ignore = true)
    @Mapping(target = IdentificacionEntity.Atributos.CLIENTE, source = "entity")
    IdentificacionEntity toIdentificacionEntity(ClienteDto cliente, ClienteEntity entity);
}
