package com.br.imobiliaria.controllers.docs;

import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Cliente;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteControllerDocs {
    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorna cliente por id",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Cliente.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cliente não encontrado"
            )
    })
    ResponseEntity<?> getById(@PathVariable @NotNull String id);

    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente criado com sucesso",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Cliente.class)
                            )
                    }
            )
    })
    ResponseEntity<?> save(@RequestBody ClienteCreateDTO createClienteDTO);
}
