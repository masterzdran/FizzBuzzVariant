package exercices.models;

public class ExerciseThree extends ExerciseTwo {
	private final String ThreeMapWord = "CMAS";
	private final String HasThreeMapWord = "good";
	private final String FiveMapWord = "systems";
	private final String FiftheenMapWord = "CMASsystems";
	
	@Override
	public String processRange(int startNumberIncluded, int endNumberIncluded) {
		String processResult = super.processRange(startNumberIncluded, endNumberIncluded);
		String reportResult = reportProcess(processResult);
		return reportResult;
	}

	private String reportProcess(String processResult) {

		int[] results = {0,0,0,0};
		String[] matches = {ThreeMapWord,HasThreeMapWord,FiveMapWord,FiftheenMapWord};
		int integers = 0;
		
		
		String[] words = processResult.split(" ");

		integers = processResult(results, matches, integers, words);
		
		StringBuffer report = generateReport(processResult, results, matches, integers);

		return report.toString();
	}

	private StringBuffer generateReport(String processResult, int[] results, String[] matches, int integers) {
		StringBuffer report = new StringBuffer();
		report.append(processResult).append(System.lineSeparator());
		for(int wordToMacth=0;wordToMacth<matches.length;wordToMacth++)
		{
			report.append(matches[wordToMacth]).append(": ").append(results[wordToMacth]).append(System.lineSeparator());;
		}
		report.append("integer: ").append(integers);
		return report;
	}

	private int processResult(int[] results, String[] matches, int integers, String[] words) {
		boolean match = false;
		for(int i = 0;i<words.length;i++) 
		{
			match = false;
			for(int wordToMacth=0;wordToMacth<matches.length;wordToMacth++) 
			{

				if (words[i].equals(matches[wordToMacth]))
				{
					results[wordToMacth]++;
					match = true;
					break;
				}
			}
			if(!match) 
			{
				integers++;
			}
		}
		return integers;
	}
}
