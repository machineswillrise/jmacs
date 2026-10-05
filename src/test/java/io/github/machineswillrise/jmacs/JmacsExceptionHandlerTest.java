package io.github.machineswillrise.jmacs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;

import javafx.stage.Stage;
import javafx.stage.Window;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JmacsExceptionHandlerTest
{
	@BeforeAll
	public static void initToolkit()
	{
		Platform.startup(() -> {});
	}

	@Test
	public void testHandlerShowsAlert() throws InterruptedException
	{
		CountDownLatch latch = new CountDownLatch(1);

		Platform.runLater(() ->
		{
			JmacsExceptionHandler handler = new JmacsExceptionHandler();
			handler.uncaughtException(Thread.currentThread(), new RuntimeException("Test exception"));

			new Thread(() ->
			{
				try
				{
					Thread.sleep(500);
					Platform.runLater(() ->
					{
						for (Window w : Window.getWindows())
						{
							if (w instanceof Stage stage)
							{
								stage.close();
							}
						}

						latch.countDown();
					});
				}
				catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
			}).start();
		});

		assertTrue(latch.await(5, TimeUnit.SECONDS));
	}
}
