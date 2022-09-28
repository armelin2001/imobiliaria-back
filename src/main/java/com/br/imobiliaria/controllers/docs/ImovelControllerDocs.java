package com.br.imobiliaria.controllers.docs;

import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.dto.response.RetornoGenericoLista;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ImovelControllerDocs {
    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Imovel criado com sucesso",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoGenerico.class)
                            )
                    }
            )
    })
    ResponseEntity<?> save(@RequestBody ImovelCreateDTO imovelCreateDTO);

    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista todos os imoveis",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoGenericoLista.class)
                            )
                    }
            )
    })
    ResponseEntity<?> getAll();

    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorna imovel por id",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoGenerico.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "imovel não encontrado",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoGenerico.class)
                            )
                    }
            )
    })
    ResponseEntity<?> getById(@PathVariable @NotNull String id);

    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Remove um imovel por id",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoGenerico.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "imovel não encontrado",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoGenerico.class)
                            )
                    }
            )
    })
    ResponseEntity<?> delete(@PathVariable @NotNull String id);
}
