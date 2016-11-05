/*
 * Copyright (C) 2016 João
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.joaops.brewer.controller;

import br.com.joaops.brewer.model.Cerveja;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author João
 */
@Controller
public class CervejasController {
    
    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.GET)
    public String novo() {
        return "cerveja/CadastroCerveja";
    }
    
    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("mensagem", "Erro no Formulário");
            return "cerveja/CadastroCerveja";
        }
        
        //Salvar no Banco de Dados...
        
        attributes.addFlashAttribute("mensagem", "Cerveja Salva com Sucesso!");
        System.out.println(">>>>> nome: "+cerveja.getNome());
        System.out.println(">>>>> sku: "+cerveja.getSku());
        return "redirect:/cervejas/novo";
    }
    
}