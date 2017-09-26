package br.senac.rn.gerenciador.dao;

import br.senac.rn.gerenciador.model.Empresa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpresaDAO {

    private final static Map<Integer, Empresa> EMPRESAS = new HashMap();
    
    static {
        geraIdEAdiciona(new Empresa("Doceria Bela Vista"));
        geraIdEAdiciona(new Empresa("Ferragens Docel"));
        geraIdEAdiciona(new Empresa("Senac"));
        geraIdEAdiciona(new Empresa("Google"));
        geraIdEAdiciona(new Empresa("Facebook"));
        geraIdEAdiciona(new Empresa("Iskisita Atacado"));
        geraIdEAdiciona(new Empresa("Rodante"));
    }
    
    public Collection buscaPorSimilaridade(String nome) {
        if (nome == null) {
            return EMPRESAS.values();
        }
        List<Empresa> similares = new ArrayList();
        for (Empresa empresa : EMPRESAS.values()) {
            if (empresa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                similares.add(empresa);
            }
        }
        return similares;
    }
    
    public void adiciona(Empresa empresa) {
        geraIdEAdiciona(empresa);
    }

    private static void geraIdEAdiciona(Empresa empresa) {
        int id = EMPRESAS.size() + 1;
        empresa.setId(id);
        EMPRESAS.put(id, empresa);
    }
    
}
