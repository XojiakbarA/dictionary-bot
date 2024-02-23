package org.example.model;

import java.util.List;
import lombok.Data;

@Data
public class DefItem{
	private String pos;
	private String text;
	private List<TrItem> tr;
	private String ts;
}