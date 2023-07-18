package app.dto;

import java.util.HashMap;
import java.util.Map;

import jakarta.json.bind.annotation.JsonbProperty;

import app.model.Poi;
import app.model.Position;



public class PoiResponseData {
	@JsonbProperty("id")
	private Long osmId;
	private String poiType;
	private Position position;
	private Map<String, String> tags = new HashMap<>();

	public Long getOsmId() {
		return osmId;
	}

	public void setOsmId(Long osmId) {
		this.osmId = osmId;
	}

	public String getPoiType() {
		return poiType;
	}

	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public static PoiResponseData fromEntity(Poi entity) {
		PoiResponseData poi = new PoiResponseData();
		poi.setOsmId(entity.getOsmId());
		poi.setPoiType(entity.getPoiType());
		poi.setPosition(entity.getPosition());

		return poi;
	}
}
