package br.com.zup.slot_machine.service;

import br.com.zup.slot_machine.controllers.dtos.MachineDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SlotMachineService {
    public List<MachineDTO> getMachine() {
        int points = 0;
        int difficulty = 3;
        List<String> items = Arrays.asList("Banana", "Strawberry", "Star");
        List<String> sweepstake = new ArrayList<>();
        List<MachineDTO> resultDTOs = new ArrayList<>();

        for (int index = 0; index < difficulty; index++) {
            int sortition = (int) (Math.random() * items.size());
            String itemDrawn = items.get(sortition);
            sweepstake.add(itemDrawn);
            points += calculatePoints(itemDrawn);
            System.out.print(itemDrawn + " | ");
        }

        boolean allEqual = suchlikeItem(sweepstake);
        if (allEqual) {
            points *= 100;
        }

        System.out.println("\n Points: " + points);

        MachineDTO resultDTO = new MachineDTO();
        resultDTO.setFirstSymbol(sweepstake.get(0));
        resultDTO.setSecondSymbol(sweepstake.get(1));
        resultDTO.setThirdSymbol(sweepstake.get(2));
        resultDTO.setTotalPoints(points);

        resultDTOs.add(resultDTO);
        return resultDTOs;
    }

    public int calculatePoints(String item) {
        if (item.equals("Banana")) {
            return 10;
        } else if (item.equals("Strawberry")) {
            return 20;
        } else if (item.equals("Star")) {
            return 40;
        } else {
            throw new RuntimeException("Error");
        }
    }

    public boolean suchlikeItem(List<String> sweepstake) {
        String firstItem = sweepstake.get(0);
        for (String item : sweepstake) {
            if (!item.equals(firstItem)) {
                return false;
            }
        }
        return true;
    }
}
