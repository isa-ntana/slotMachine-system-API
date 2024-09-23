package br.com.zup.slot_machine.controllers.dtos;

public class MachineDTO {
    public String firstSymbol;
    public String secondSymbol;
    public String thirdSymbol;
    public int totalPoints;

    public MachineDTO() {} //padrao BEAN

    public String getFirstSymbol() {
        return firstSymbol;
    }

    public void setFirstSymbol(String firstSymbol) {
        this.firstSymbol = firstSymbol;
    }

    public String getSecondSymbol() {
        return secondSymbol;
    }

    public void setSecondSymbol(String secondSymbol) {
        this.secondSymbol = secondSymbol;
    }

    public String getThirdSymbol() {
        return thirdSymbol;
    }

    public void setThirdSymbol(String thirdSymbol) {
        this.thirdSymbol = thirdSymbol;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
