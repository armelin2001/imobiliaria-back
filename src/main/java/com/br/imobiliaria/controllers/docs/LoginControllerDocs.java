package com.br.imobiliaria.controllers.docs;

import com.br.imobiliaria.dto.request.LoginDto;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.dto.response.RetornoLogin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginControllerDocs {
    @Operation
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorna um usuario",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RetornoLogin.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario não encontrado"
            )
    })
    ResponseEntity<?> login(@RequestBody LoginDto loginDto);
}
