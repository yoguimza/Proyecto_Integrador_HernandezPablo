/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pabloh.Repository;

import com.portfolio.pabloh.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Notebook
 */
public interface RHabilidades extends JpaRepository <Habilidades, Integer> {
    Optional<Habilidades> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
}
