package org.example.model;

import java.util.List;
import lombok.Data;

@Data
public class Translate{
	private Head head;
	private List<DefItem> def;
}