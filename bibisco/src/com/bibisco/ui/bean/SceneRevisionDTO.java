package com.bibisco.ui.bean;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bibisco.BibiscoException;
import com.bibisco.PointOfView;
import com.bibisco.TaskStatus;
import com.bibisco.log.Log;

public class SceneRevisionDTO {

	private static Log mLog = Log.getInstance(SceneRevisionDTO.class);
	
	private Integer idScene;
	private Integer idRevision;
	private Integer position;
	private String title;
	private TaskStatus taskStatus;
	private String text;
	private Integer revision;
	private Integer idLocation;
	private PointOfView pointOfView;
	private Integer idCharacterPointOfView;
	private List<Integer> characters;
	private List<Integer> strands;
	private Date sceneDate;
	private List<Integer> revisions;
	 
	public List<Integer> getRevisions() {
		return revisions;
	}
	public void setRevisions(List<Integer> revisions) {
		this.revisions = revisions;
	}
	public Integer getIdScene() {
		return idScene;
	}
	public void setIdScene(Integer idScene) {
		this.idScene = idScene;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String description) {
		this.title = description;
	}
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getRevision() {
		return revision;
	}
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	public Integer getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}
	public List<Integer> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Integer> characters) {
		this.characters = characters;
	}
	public List<Integer> getStrands() {
		return strands;
	}
	public void setStrands(List<Integer> strands) {
		this.strands = strands;
	}
	public Date getSceneDate() {
		return sceneDate;
	}
	public void setSceneDate(Date sceneDate) {
		this.sceneDate = sceneDate;
	}
	public Integer getIdCharacterPointOfView() {
		return idCharacterPointOfView;
	}
	public void setIdCharacterPointOfView(Integer idCharacterPointOfView) {
		this.idCharacterPointOfView = idCharacterPointOfView;
	}
	
	public JSONObject toJSONObject() {
		
		JSONObject lJSONObject;
		
		try {
			lJSONObject = new JSONObject();
			lJSONObject.put("idCharacterPointOfView", idCharacterPointOfView);
			lJSONObject.put("idLocation", idLocation);
			lJSONObject.put("idScene", idScene);
			lJSONObject.put("pointOfView", pointOfView);
			lJSONObject.put("position", position);
			lJSONObject.put("idRevision", idRevision);
			lJSONObject.put("revision", revision);
			lJSONObject.put("sceneDate", sceneDate);
			lJSONObject.put("taskStatus", taskStatus);
			lJSONObject.put("text", text);
			lJSONObject.put("title", title);
			
			int i = 0;
			JSONArray lJSONArrayCharacters = new JSONArray();
			if (characters != null) {
				for (Integer lIntIdCharacter : characters) {
					JSONObject lJSONObjectCharacter = new JSONObject();
					lJSONObjectCharacter.put("idCharacter", lIntIdCharacter);
					lJSONArrayCharacters.put(i++, lJSONObjectCharacter);
				}
			}
			lJSONObject.put("characters", lJSONArrayCharacters);
			
			i = 0;
			JSONArray lJSONArrayRevisions = new JSONArray();
			if (revisions != null) {
				for (Integer lIntIdRevision : revisions) {
					JSONObject lJSONObjectRevision = new JSONObject();
					lJSONObjectRevision.put("idRevision", lIntIdRevision);
					lJSONArrayRevisions.put(i++, lJSONObjectRevision);
				}
			}
			lJSONObject.put("revisions", lJSONArrayRevisions);

			i = 0;
			JSONArray lJSONArrayStrands = new JSONArray();
			if (strands != null) {
				for (Integer lIntIdStrand : strands) {
					JSONObject lJSONObjectStrand = new JSONObject();
					lJSONObjectStrand.put("idStrand", lIntIdStrand);
					lJSONArrayStrands.put(i++, lJSONObjectStrand);
				}
			}
			lJSONObject.put("strands", lJSONArrayStrands);

			
		} catch (JSONException e) {
			mLog.error(e);
			throw new BibiscoException(e, BibiscoException.FATAL);
		}
		
		return lJSONObject;
	}
	public PointOfView getPointOfView() {
		return pointOfView;
	}
	public void setPointOfView(PointOfView pointOfView) {
		this.pointOfView = pointOfView;
	}
	public Integer getIdRevision() {
		return idRevision;
	}
	public void setIdRevision(Integer idRevision) {
		this.idRevision = idRevision;
	}
}