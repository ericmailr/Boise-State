import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

public class FleschStatistics implements FleschStatisticsInterface {

	private File file;
	private Scanner fileScan;
	private String inputLine, tempString, delimiter, fleschGrade, rval,
			syllString, wordLengthString, longestWord;
	private StringTokenizer tokenizer;
	private int wordCount, syllableCount, sentenceCount, syllableTotal,
			lineCount;
	private double fleschIndex;
	private boolean previousIsVowel, changeSyllCount;
	private static boolean isVowel;
	private int[] syllablesPerWord, wordLength;
	private DecimalFormat fmt;

	private ArrayList<Integer> longestWordLines;

	public FleschStatistics(File file) {
		this.file = file;
		try {

			lineCount = 0;
			longestWord = "";
			longestWordLines = new ArrayList<Integer>();
			fileScan = new Scanner(file);
			delimiter = " , .;:'\"&!?-_\n\t12345678910[]{}()@#$%^*/+-";
			syllablesPerWord = new int[16];
			wordLength = new int[24];
			while (fileScan.hasNextLine()) {
				lineCount++;
				inputLine = fileScan.nextLine();
				for (int i = 0; i < inputLine.length(); i++) {
					if (inputLine.charAt(i) == '.'
							|| inputLine.charAt(i) == ';'
							|| inputLine.charAt(i) == ':'
							|| inputLine.charAt(i) == '?'
							|| inputLine.charAt(i) == '!') {
						sentenceCount += 1;
					}
				}

				tokenizer = new StringTokenizer(inputLine, delimiter);

				wordCount += tokenizer.countTokens();

				while (tokenizer.hasMoreTokens()) {

					syllableCount = 0;
					tempString = tokenizer.nextToken();
					previousIsVowel = false;
					changeSyllCount = false;

					for (int i = 0; i < tempString.length(); i++) {

						if (isVowel(tempString.charAt(i))) {

							if (i == (tempString.length() - 1)) {

								if (!changeSyllCount) {
									syllableCount++;

								} else if (tempString.charAt(i) != 'e'
										&& tempString.charAt(i) != 'E'
										&& !previousIsVowel) {
									syllableCount++;
								}
								syllablesPerWord[syllableCount]++;

								wordLength[i + 1]++;
								// EXTRA CREDIT
								if (tempString.length() >= longestWord.length()) {
									if (tempString
											.equalsIgnoreCase(longestWord)
											&& !longestWordLines
													.contains(lineCount)) {
										longestWordLines.add(lineCount);
									}
									if (tempString.length() > longestWord
											.length()) {

										longestWord = tempString;
										longestWordLines.clear();
										if (!longestWordLines
												.contains(lineCount)) {
											longestWordLines.add(lineCount);
										}
									}
								}
							} else if (!previousIsVowel) {
								syllableCount++;
								changeSyllCount = true;
								previousIsVowel = true;
							}

						} else if (!isVowel(tempString.charAt(i))) {
							previousIsVowel = false;
							if (i == (tempString.length() - 1)) {
								if (!changeSyllCount) {
									syllableCount++;
								}
								syllablesPerWord[syllableCount]++;
								wordLength[i + 1]++;
								// EXTRA CREDIT
								if (tempString.length() >= longestWord.length()) {
									if (tempString
											.equalsIgnoreCase(longestWord)
											&& !longestWordLines
													.contains(lineCount)) {
										longestWordLines.add(lineCount);
									}
									if (tempString.length() > longestWord
											.length()) {

										longestWord = tempString;
										longestWordLines.clear();
										if (!longestWordLines
												.contains(lineCount)) {
											longestWordLines.add(lineCount);
										}
									}
								}

							}
						}
					}
					syllableTotal += syllableCount;
				}

			}

			fleschIndex = 206.835 - 1.015 * wordCount / sentenceCount - 84.6
					* syllableTotal / wordCount;

			if (91 <= fleschIndex && fleschIndex <= 100) {
				fleschGrade = "5th grader";
			} else if (81 <= fleschIndex && fleschIndex < 91) {
				fleschGrade = "6th grader";
			} else if (71 <= fleschIndex && fleschIndex < 81) {
				fleschGrade = "7th grader";
			} else if (66 <= fleschIndex && fleschIndex < 71) {
				fleschGrade = "8th grader";
			} else if (61 <= fleschIndex && fleschIndex < 66) {
				fleschGrade = "9th grader";
			} else if (51 <= fleschIndex && fleschIndex < 61) {
				fleschGrade = "High school student";
			} else if (31 <= fleschIndex && fleschIndex < 51) {
				fleschGrade = "College student";
			} else if (0 <= fleschIndex && fleschIndex < 31) {
				fleschGrade = "College graduate";
			} else if (fleschIndex < 0) {
				fleschGrade = "Law school graduate";
			}

		} catch (IOException e) {
			System.out.println("File \"" + file + "\" could not be read.");
		}

	}

	/**
	 * Determines whether a character is a vowel
	 * 
	 * @param a
	 * 
	 * @return isVowel boolean
	 */
	public static boolean isVowel(char a) {

		isVowel = false;
		char[] vowels = new char[12];
		vowels[0] = 'a';
		vowels[1] = 'A';
		vowels[2] = 'e';
		vowels[3] = 'E';
		vowels[4] = 'i';
		vowels[5] = 'I';
		vowels[6] = 'o';
		vowels[7] = 'O';
		vowels[8] = 'u';
		vowels[9] = 'U';
		vowels[10] = 'y';
		vowels[11] = 'Y';
		for (int j = 0; j < vowels.length; j++) {

			if (a == vowels[j]) {
				isVowel = true;

			}
		}
		return isVowel;
	}

	/**
	 * return word count
	 */
	@Override
	public int getWordCount() {
		return wordCount;
	}

	/**
	 * return syllable Total
	 */
	@Override
	public int getSyllableCount() {
		return syllableTotal;
	}

	/**
	 * return number of sentences
	 */
	@Override
	public int getSentenceCount() {
		return sentenceCount;
	}

	/**
	 * returns array with frequency of words of each length
	 */
	@Override
	public int[] getWordLengthCount() {
		return wordLength;
	}

	/**
	 * returns array with frequency of words with a number of syllables
	 */
	@Override
	public int[] getSyllablePerWordCount() {
		return syllablesPerWord;
	}

	/**
	 * returns the flesch index of the text file
	 */
	@Override
	public double getFleschIndex() {
		return fleschIndex;
	}

	/**
	 * returns the grade level of the flesch index
	 */
	@Override
	public String getFleschGrade() {
		return fleschGrade;
	}

	@Override
	public String toString() {
		syllString = "";
		wordLengthString = "";
		fmt = new DecimalFormat("0.00");
		rval = "Flesch Statistics for "
				+ this.file
				+ "\n==========================================================\n"
				+ getWordCount() + " words\n" + getSentenceCount()
				+ " sentences\n" + getSyllableCount() + " syllables\n"
				+ "------------------------------------"
				+ "\nSyllable Count: \n\tcount\tfrequency\n\t-----\t---------";
		for (int i = 0; i < syllablesPerWord.length; i++) {
			if (syllablesPerWord[i] != 0) {
				syllString += "\n\t" + (i) + "\t" + syllablesPerWord[i];
			}

		}
		rval += syllString + "\n------------------------------------"
				+ "\nWord Lengths: \n\tlength\tfrequency\n\t------\t---------";

		for (int i = 0; i < wordLength.length; i++) {
			if (wordLength[i] != 0) {
				wordLengthString += "\n\t" + (i) + "\t" + wordLength[i];
			}

		}
		rval += wordLengthString
				+ "\n------------------------------------\nFlesch Index: "
				+ fmt.format(fleschIndex)
				+ "\nFlesch Grade: "
				+ fleschGrade

				+ "\nLongest Word: "
				+ longestWord
				+ "\nThis word appears on line(s): "
				+ longestWordLines
				+ "\n==========================================================";

		return rval;
	}

}
