package Task3_SaveObjectsToFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaveObjectsToStream implements Serializable {
	private String title;
	private String director;
	private String[] actors;
	private LocalDate releaseDate;
	
	public SaveObjectsToStream() {
		
	}
	
	public SaveObjectsToStream(String title, String director, String[] actors,
			LocalDate releaseDate) {
		this.setTitle(title);
		this.setDirector(director);
		this.setActors(actors);
		this.setDate(releaseDate);
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public LocalDate getDate() {
		return releaseDate;
	}

	public void setDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<SaveObjectsToStream> movies(List<SaveObjectsToStream> moviesRepository ) {
		return moviesRepository;
	}
	
	public void saveDataToRepository(List<SaveObjectsToStream> moviesRepository) {
		try(ObjectOutputStream objectOutputStream = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(new File("src/Repository.txt"))))) {
			objectOutputStream.writeObject(moviesRepository);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void loadDataToRepository() {
		try(ObjectInputStream objectInputStream = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(new File("src/Repository.txt"))))) {
			System.out.println(objectInputStream.readObject());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}