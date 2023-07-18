package app.dao;

import java.util.List;

import app.model.Poi;


public interface PoiDAO {
	Poi readPoi(long id);

	List<Poi> readAllPois();
}
