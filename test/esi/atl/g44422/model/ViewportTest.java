package esi.atl.g44422.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ViewportTest {

	@Test
	public void addCanvasHasCanvas() {
		Viewport myViewport = new Viewport();
		Canvas myCanvas = new Canvas(80, 50, ' ', false, true, 0);
		myViewport.getCanvases().add(myCanvas);
		assertTrue(myViewport.getCanvases().get(0) == myCanvas);
	}

	@Test
	public void newViewportCanvasesIsEmpty() {
		Viewport myViewport = new Viewport();
		assertTrue(myViewport.getCanvases().isEmpty());
	}

	@Test
	public void addCanvasIsNotEmpty() {
		Canvas myCanvas = new Canvas(80, 50, ' ', false, true, 0);
		Viewport myViewport = new Viewport();
		myViewport.getCanvases().add(myCanvas);
		assertFalse(myViewport.getCanvases().isEmpty());
	}

	@Test
	public void getCurrentCanvas() {
		Viewport myViewport = new Viewport();
		Canvas myCanvas = new Canvas(80, 50, ' ', false, true, 0);
		myViewport.getCanvases().add(myCanvas);
		assertEquals(myViewport.getCurrentCanvas(), myCanvas);
	}

	@Test
	public void getCanvasWithId() {
		Viewport myViewport = new Viewport();
		Canvas myCanvas = new Canvas(80, 50, ' ', false, true, 1);
		myViewport.getCanvases().add(myCanvas);
		assertEquals(myViewport.getCanvasWithId(1), myCanvas);
	}

	@Test
	public void hasCanvasWithId() {
		Viewport myViewport = new Viewport();
		Canvas myCanvas = new Canvas(80, 50, ' ', false, true, 1);
		myViewport.getCanvases().add(myCanvas);
		assertTrue(myViewport.hasCanvasWithId(1));
	}
}
