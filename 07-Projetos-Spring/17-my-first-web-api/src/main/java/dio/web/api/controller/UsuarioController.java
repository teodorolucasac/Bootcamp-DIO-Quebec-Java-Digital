package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping()
    public List<Usuario> getUsers(){
        return usuarioRepository.listAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return usuarioRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        usuarioRepository.remove(id);
    }

    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
