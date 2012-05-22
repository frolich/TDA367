package projekt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Tile;
import cha.domain.Categories;

public class TestTile {
	
	@Test
	public void testTile() {
		Category c = Category.WORDJUMBLE;
		Tile t = new Tile(c);
		Tile f = new Tile(c);
		String s1 = t.toString();
		String s2 = f.toString();
		assertTrue(s1.contains(s2));
	}
}
