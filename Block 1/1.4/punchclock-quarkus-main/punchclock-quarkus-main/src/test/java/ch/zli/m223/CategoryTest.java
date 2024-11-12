package ch.zli.m223;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Category;
import ch.zli.m223.model.Entry;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;




public class CategoryTest {

  private Category category;

  @BeforeEach
  public void setUp() {
    category = new Category();
  }

  @Test
  public void testGetAndSetId() {
    // Arrange
    Long id = 1L;

    // Act
    category.setId(id);

    // Assert
    assertEquals(id, category.getId());
  }

  @Test
  public void testGetAndSetTitle() {
    // Arrange
    String title = "Test Title";

    // Act
    category.setTitle(title);

    // Assert
    assertEquals(title, category.getTitle());
  }

  @Test
  public void testGetAndSetEntries() {
    // Arrange
    Set<Entry> entries = new HashSet<>();

    // Act
    category.setEntries(entries);

    // Assert
    assertEquals(entries, category.getEntries());
  }
}