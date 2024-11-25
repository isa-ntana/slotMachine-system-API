package br.com.zup.slot_machine.controllers.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineDTO {
    public String firstSymbol;
    public String secondSymbol;
    public String thirdSymbol;
    public int totalPoints;

    public MachineDTO() {} //padrao BEAN
}
