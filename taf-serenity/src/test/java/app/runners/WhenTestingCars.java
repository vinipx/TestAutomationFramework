package app.runners;

import app.steps.CarSteps;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
@Narrative(text={"Car tests."})
public class WhenTestingCars {

    @Steps
    CarSteps carSteps;

    @Test
    public void testGetAllCars() {
        Response response = carSteps.getAllCars();

        System.out.println(response.asString());
    }

    @Test
    public void testGetCar1_expectId1() {
        final int CAR_ID = 1;

        Response response = carSteps.getCar(CAR_ID);

        carSteps.assertCardId(response.jsonPath(), CAR_ID);
    }
}