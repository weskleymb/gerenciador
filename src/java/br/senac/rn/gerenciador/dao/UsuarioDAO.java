package br.senac.rn.gerenciador.dao;

import br.senac.rn.gerenciador.model.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {

    private final static Map<String, Usuario> USUARIOS = new HashMap();
    
    static {
        USUARIOS.put("eder@rn.senac.br", new Usuario("eder@rn.senac.br", "12345"));
        USUARIOS.put("dario@rn.senac.br", new Usuario("dario@rn.senac.br", "98765"));
    }
    
    public Usuario buscarPorEmailESenha(String email, String senha) {
        if (!USUARIOS.containsKey(email)) {
            return null;
        }
        Usuario usuario = new Usuario(email, senha);
        if (usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }
    
}
