package br.com.zup.slot_machine.controllers;

import br.com.zup.slot_machine.service.SlotMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sortition")
public class MachineController {
    @Autowired
    private SlotMachineService slotMachine;

    @GetMapping
    public ResponseEntity<?> sortitionMachine(){
        return ResponseEntity.ok(slotMachine.getMachine());
    }
}
