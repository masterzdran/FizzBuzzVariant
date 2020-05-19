package exercise.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import exercices.abstractions.IExercise;
import exercices.models.ExerciseOne;


public class ExerciseOneTests {
	protected final String ThreeMapWord = "CMAS";
	protected final String FiveMapWord = "systems";
	protected final String FiftheenMapWord = "CMASsystems";
	private final String expectedResult = "1 2 CMAS 4 systems CMAS 7 8 CMAS systems 11 CMAS 13 14 CMASsystems 16 17 CMAS 19 systems";
	
	@ParameterizedTest
	@ValueSource(ints = { 0, -1, Integer.MIN_VALUE })
	public void Process_NonPositiveNumbers_Should_Throw_IllegalArgumentException(int number) 
	{
		IExercise exercise = new ExerciseOne();
		assertThrows(
				IllegalArgumentException.class, 
				() -> exercise.process(number)
				);
	}
	
	@ParameterizedTest
	@CsvSource({"1,0", "1,-1"})
	public void ProcessRange_EndRangeLessThanBegin_Should_Throw_IllegalArgumentException(int startNumberIncluded, int endNumberIncluded) 
	{
		IExercise exercise = new ExerciseOne();
		assertThrows(
				IllegalArgumentException.class, 
				() -> exercise.processRange(startNumberIncluded,endNumberIncluded)
				);
	}
	
	@ParameterizedTest
	@CsvSource({"1,20"})
	public void ProcessRange_Should_Return_Expected_String(int startNumberIncluded, int endNumberExcluded) 
	{
		IExercise exercise = new ExerciseOne();
		String result = exercise.processRange(startNumberIncluded, endNumberExcluded);
		assertEquals(expectedResult, result);
	}
	@ParameterizedTest
	@ValueSource(ints = { 3, 6, 9,12,18,21,24,27,33 })
	public void Process_MultiplesOfThree_And_Not_MultipleOfFiftheen_Should_Return_CMAS(int number)
	{
		IExercise exercise = new ExerciseOne();
		String result = exercise.process(number);
		assertEquals(ThreeMapWord, result);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 5, 10, 20,25,35,40,50,55,65 })
	public void Process_MultiplesOfFive_And_Not_MultipleOfFiftheen_Should_Return_systems(int number)
	{
		IExercise exercise = new ExerciseOne();
		String result = exercise.process(number);
		assertEquals(FiveMapWord, result);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 15,30,45,60,75,90 })
	public void Process_MultiplesOfFiftheen_Should_Return_CMASsystems(int number)
	{
		IExercise exercise = new ExerciseOne();
		String result = exercise.process(number);
		assertEquals(FiftheenMapWord, result);	
	}
}
