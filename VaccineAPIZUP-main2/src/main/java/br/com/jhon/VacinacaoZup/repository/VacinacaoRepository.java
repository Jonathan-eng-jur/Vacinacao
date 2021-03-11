package br.com.jhon.VacinacaoZup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jhon.VacinacaoZup.entity.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
}
