package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;
import ch.zli.m223.model.Tag;
import ch.zli.m223.model.Entry;


public class TagTest {

  @Test
  public void testGetAndSetId() {
    // Arrange
    Tag tag = new Tag();
    Long id = 1L;

    // Act
    tag.setId(id);
    Long result = tag.getId();

    // Assert
    assertEquals(id, result);
  }

  @Test
  public void testGetAndSetTitle() {
    // Arrange
    Tag tag = new Tag();
    String title = "Test Title";

    // Act
    tag.setTitle(title);
    String result = tag.getTitle();

    // Assert
    assertEquals(title, result);
  }

  @Test
  public void testGetAndSetEntries() {
    // Arrange
    Tag tag = new Tag();
    Set<Entry> entries = new HashSet<>();

    // Act
    tag.setEntries(entries);
    Set<Entry> result = tag.getEntries();

    // Assert
    assertEquals(entries, result);
  }
}