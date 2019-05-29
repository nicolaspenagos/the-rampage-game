package modelTest;

import model.CustomDateComparator;
import model.PlayerScore;
import model.Scores;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import customsExceptions.NothingSelectedException;

class ScoreTest {

	// -------------------------------------
	// Associations
	// -------------------------------------

	private Scores sc;
	private PlayerScore py;

	// -------------------------------------
	// Scenarios
	// -------------------------------------
	public void setUpScenary1() {

	}

	public void setUpScenary2() {
		py = new PlayerScore("Jester", 200, 200, null);
		try {
			sc = new Scores(py);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//-------------------------------------
	// Test
	//-------------------------------------
	@Test
	void loadTest() {
		setUpScenary2();
		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		for (int i = 0; i < array.length; i++) {
			assertTrue("The file was not loaded", array[i].getRanking() == i + 1);
		}
	}

	@Test
	void selecSortingTest() {
		setUpScenary2();

		try {
			sc.selectSorting("Nickname - BubbleSort");
			assertTrue("The assignament was not done properlty", sc.getTypeOfSorting() == Scores.NICKNAME);
			sc.selectSorting("Hits - Selection");
			assertTrue("The assignament was not done properlty", sc.getTypeOfSorting() == Scores.HITS);
			sc.selectSorting("Score - Selection");
			assertTrue("The assignament was not done properlty", sc.getTypeOfSorting() == Scores.SCORE);
			sc.selectSorting("Time - Insertion");
			assertTrue("The assignament was not done properlty", sc.getTypeOfSorting() == Scores.TIME);
			sc.selectSorting("Date - Comparator");
			assertTrue("The assignament was not done properlty", sc.getTypeOfSorting() == Scores.DATE);
		} catch (NothingSelectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void sortByDateComparatorTest() {
		setUpScenary2();

		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		sc.sortByDateComparator();
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1)
				assertTrue("The array was not ordered correctly",
						new CustomDateComparator().compare(array[i], array[i + 1]) <= 0);
		}
	}

	@Test
	void sortByScoreSelectionTest() {
		setUpScenary2();

		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		sc.sortByScoreSelection();
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1)
				assertTrue("The array was not ordered correctly", array[i].getScore() >= array[i + 1].getScore());
		}
	}

	@Test
	void sortByNicknameBubbleSortTest() {
		setUpScenary2();

		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		sc.sortByNicknameBubbleSort();
		for (int j = 0; j < array.length; j++) {
			if (j < array.length - 1)
				assertTrue("The array was not ordered correctly",
						array[j].getNickName().compareTo(array[j + 1].getNickName()) <= 0);
		}

	}

	@Test
	void sortByHitsSelectionTest() {
		setUpScenary2();

		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		sc.sortByHitsSelection();
		for (int j = 0; j < array.length; j++) {
			if (j < array.length - 1)
				assertTrue("The array was not ordered correctly", array[j].getHits() <= array[j + 1].getHits());
		}

	}

	@Test
	void sortByRankingBubbleSortTest() {
		setUpScenary2();

		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		sc.sortByRankingBubbleSort();
		for (int j = 0; j < array.length; j++) {
			if (j < array.length - 1)
				assertTrue("The array was not ordered correctly", array[j].getRanking() <= array[j + 1].getRanking());
		}

	}

	@Test
	void serachTest() {
		setUpScenary2();
		assertNotNull("The methos is not retunig a existing value", sc.binarySearchByRanking(2));
	}

	@Test
	void serachTest2() {
		setUpScenary2();
		assertNotNull("The methos is not retunig a existing value", sc.binarySearchByNickName("Ana"));
	}

	@Test
	void savePlayerTest() {
		setUpScenary1();
		PlayerScore p = new PlayerScore("juan", 334, 233, "30:00:00");
		try {
			Scores s = new Scores(p);
			s.savePlayer();
			assertNotNull("The methos is not retunig a existing value", s.binarySearchByNickName("juan"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void generateTopFiveTest() {
		setUpScenary2();
		sc.generateTopFive();

		PlayerScore[] array = sc.getAllPlayersScoresToShow();
		PlayerScore[] array2 = sc.getTopFive();
		sc.sortByRankingBubbleSort();
		for (int i = 0; i < 5; i++) {
			assertTrue("The method did not generate the array", array[i].getNickName() == array2[i].getNickName());
		}
	}

	@Test
	void addNodeTest() {
		setUpScenary2();
		sc.generateTopFive();

		assertNotNull("The root were not added ", sc.getRoot());
	}

	@Test
	void palindromeTest() {
		setUpScenary2();
		sc.generateTopFive();

		assertNotNull("The root were not added ", sc.palindrome1());
	}

}
