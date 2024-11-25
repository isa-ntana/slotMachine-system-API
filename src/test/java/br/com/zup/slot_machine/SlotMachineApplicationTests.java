package br.com.zup.slot_machine;

import br.com.zup.slot_machine.controllers.dtos.MachineDTO;
import br.com.zup.slot_machine.service.SlotMachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SlotMachineApplicationTests {

	@Autowired
	private SlotMachineService service;

	@Test
	void contextLoads() {
	}

	@Test
	void testCalculatePoints() {
		int bananaPoints = service.calculatePoints("Banana");
		int strawberryPoints = service.calculatePoints("Strawberry");
		int starPoints = service.calculatePoints("Star");

		assertEquals(10, bananaPoints);
		assertEquals(20, strawberryPoints);
		assertEquals(40, starPoints);
	}

	@Test
	void testSuchlikeItem() {
		List<String> sweepstakeAllEqual = List.of("Banana", "Banana", "Banana");
		assertTrue(service.suchlikeItem(sweepstakeAllEqual));

		List<String> sweepstakeDifferent = List.of("Banana", "Strawberry", "Star");
		assertFalse(service.suchlikeItem(sweepstakeDifferent));
	}

	@Test
	void testTotalPointsCalculation() {
		List<MachineDTO> result = service.getMachine();
		assertNotNull(result);
		int totalPoints = result.get(0).getTotalPoints();
		assertTrue(totalPoints >= 10 && totalPoints <= 120);
	}
}
