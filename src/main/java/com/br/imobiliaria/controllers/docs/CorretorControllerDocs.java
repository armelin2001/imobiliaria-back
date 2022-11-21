package com.br.imobiliaria.controllers.docs;

import com.br.imobiliaria.dto.request.CorretorCreateDto;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.dto.response.RetornoGenericoLista;
import com.br.imobiliaria.entity.Corretor;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CorretorControllerDocs {
    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Corretor criado com sucesso",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Corretor.class)
                            )
                    }
            )
    })
    ResponseEntity<?> salvar(@RequestBody CorretorCreateDto corretor);

    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista todos corretores de imoveis",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Corretor.class)
                            )
                    }
            )
    })
    ResponseEntity<?> getAll();

    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorna corretor por id",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Corretor.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Corretor não encontrado"
            )
    })
    ResponseEntity<?>getById(@PathVariable("id") @NotNull String id);
}
