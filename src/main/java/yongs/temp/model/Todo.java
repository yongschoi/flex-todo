package yongs.temp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Todo {
    @Id
    long id;
    String title;
    String complete;
    
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", complete=" + complete + "]";
    }
}
