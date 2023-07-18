package app.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import app.dto.PoiResponseData;
import app.dao.PoiDAO;
import app.model.Poi;

import java.util.List;
import java.util.stream.Collectors;

@Path("poi")
public class PoiController {

	@Inject
	private PoiDAO poiDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPois() {
		final List<Poi> allPois = poiDAO.readAllPois();

		final List<PoiResponseData> poiData = allPois.parallelStream().map(PoiResponseData::fromEntity)
				.collect(Collectors.toList());

		return Response.ok().entity(poiData).build();
	}

	@GET
	@Path("{poiId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPoiById(@PathParam("poiId") long poiId) {
		final Poi poi = poiDAO.readPoi(poiId);

		final PoiResponseData poiData = PoiResponseData.fromEntity(poi);

		return Response.ok().entity(poiData).build();
	}


}
