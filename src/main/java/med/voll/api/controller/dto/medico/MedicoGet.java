package med.voll.api.controller.dto.medico;

import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;

public record MedicoGet(String nome, String email, String crm, Especialidade especialidade) {
    public MedicoGet(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
