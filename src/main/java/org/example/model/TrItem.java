package org.example.model;

import java.util.List;
import lombok.Data;

@Data
public class TrItem{
	private String gen;
	private String pos;
	private List<MeanItem> mean;
	private String text;
	private int fr;
	private List<SynItem> syn;
	private String asp;
}