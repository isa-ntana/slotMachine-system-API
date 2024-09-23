package br.com.zup.slot_machine.service;

import br.com.zup.slot_machine.controllers.dtos.MachineDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SlotMachineService {
    public List<MachineDTO> getMachine() {
        int pontos = 0;
        int dificuldade = 3;
        List<String> itens = Arrays.asList("Banana", "Morango", "Estrela");
        List<String> sorteios = new ArrayList<>();
        List<MachineDTO> resultadoDTOs = new ArrayList<>();

        for (int indice = 0; indice < dificuldade; indice++) {
            int sorteio = (int) (Math.random() * itens.size());
            String itemSorteado = itens.get(sorteio);
            sorteios.add(itemSorteado);
            pontos += calcularPontos(itemSorteado);
            System.out.print(itemSorteado + " | ");
        }

        boolean todasIguais = todasIguais(sorteios);
        if (todasIguais) {
            pontos *= 100;
        }

        System.out.println("\nPontos obtidos: " + pontos);

        MachineDTO resultadoDTO = new MachineDTO();
        resultadoDTO.setFirstSymbol(sorteios.get(0));
        resultadoDTO.setSecondSymbol(sorteios.get(1));
        resultadoDTO.setThirdSymbol(sorteios.get(2));
        resultadoDTO.setTotalPoints(pontos);

        resultadoDTOs.add(resultadoDTO);
        return resultadoDTOs;
    }

    private int calcularPontos(String item) {
        if (item.equals("Banana")) {
            return 10;
        } else if (item.equals("Morango")) {
            return 20;
        } else if (item.equals("Estrela")) {
            return 40;
        } else {
            throw new RuntimeException("Erro ao roletar");
        }
    }

    private boolean todasIguais(List<String> sorteios) {
        String primeiroItem = sorteios.get(0);
        for (String item : sorteios) {
            if (!item.equals(primeiroItem)) {
                return false;
            }
        }
        return true;
    }
}
