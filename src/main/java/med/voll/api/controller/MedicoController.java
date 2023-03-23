package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.controller.dto.medico.MedicoGet;
import med.voll.api.controller.dto.medico.MedicoPost;
import med.voll.api.controller.dto.medico.MedicoPut;
import med.voll.api.domain.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoPost dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoGet> listar(@PageableDefault(sort = {"nome"}) Pageable page) {
        return repository.findAll(page).map(MedicoGet::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoPut dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
    }
}
