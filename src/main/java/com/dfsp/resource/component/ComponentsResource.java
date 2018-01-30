package com.dfsp.resource.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dfsp.resource.user.UserDAO;

@Path("snapshot")
public class ComponentsResource {
	

	@GET
	@Path("/selector")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Selector> getSelector() {
		return ComponentDAO.getSelectorsDefault();
		// return ComponentDAO.getSelectors();
	}

	// @GET
	// @Path("/chart")
	// @Produces(MediaType.APPLICATION_JSON)
	// public List<ChartConfig> getChart() {
	// return ComponentDAO.getCharts();
	// }

	@GET
	@Path("/charts/random")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> getChart() {
		return ComponentDAO.getChartsRandom();
	}
	
	@GET
	@Path("/table/random")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> getTable() {
		return ComponentDAO.getTableRandom();
	}

	// @GET
	// @Path("/chart/{id}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public List<Chart> getCurrenChart(@PathParam("id") int id) {
	// return ComponentDAO.getCurrenChart(id);
	// }

	@GET
	@Path("/chart/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getChartUsers(@PathParam("id") int id)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Map<String, Object> result = new HashMap<>();
		result.put("config", ComponentDAO.getChartConfig(id));
		result.put("users", UserDAO.getAllUsers());
		return result;
	}
}