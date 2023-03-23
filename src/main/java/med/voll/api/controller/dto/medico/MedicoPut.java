package med.voll.api.controller.dto.medico;

import jakarta.validation.constraints.NotNull;

public record MedicoPut(
        @NotNull Long id,
        String nome,
        DadosEndereco endereco
) {
}
