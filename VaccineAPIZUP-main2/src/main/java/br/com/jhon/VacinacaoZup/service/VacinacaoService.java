package br.com.jhon.VacinacaoZup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhon.VacinacaoZup.entity.Vacinacao;
import br.com.jhon.VacinacaoZup.repository.VacinacaoRepository;

@Service
public class VacinacaoService {
    @Autowired
    VacinacaoRepository vacinacaoRepository;

    public Vacinacao create(Vacinacao vacinacao){
        return vacinacaoRepository.save(vacinacao);
    }


}
