package com.paradigma0621.timeflow.model;

import java.util.ArrayList;
import java.util.List;

import com.paradigma0621.timeflow.model.timeWorker.ClockReport;
public class FileDataBase {
	private List<Paragraph> docParagraphs = new ArrayList<>();
	final int indexUsedToReferThatTheParentOfOneParagraphIsTheDocument = -1;

	public void addParagraph(String text) {
		Paragraph p = new Paragraph(text);
		docParagraphs.add(p);
	}

	public void findAParentForEachTreeItem() {
		for (int i = docParagraphs.size() - 1; i >= 0; i--) {
			
			Paragraph paragraphBellowInTreeView = docParagraphs.get(i);
			
			for (int k = i - 1; k >= 0; k--) {
				Paragraph paragraphAboveInTreeView = docParagraphs.get(k);

				if (isTheParagraphAboveParentOfTheBellowInTheTreeView(paragraphBellowInTreeView, paragraphAboveInTreeView)) {
					paragraphBellowInTreeView.setIndexOfParentInsideDocParagraphs(k);
					break;
				}
			
				if (isParagraphSimpleText(paragraphBellowInTreeView)) { 
					if (isParagraphNotSimpleText(paragraphAboveInTreeView)) {
						paragraphBellowInTreeView.setIndexOfParentInsideDocParagraphs(k);
						break; // found a parent, for the simple text, above... stop searching
					}
				}
			}
		}
	}

	/**
	 * 		Associate the treeItem variable of each Paragraph to its corresponding new 
	 * created TreeItem object.
	 * 
	 * 		@param treeItemNodeBase the Parent of all treeItems. It's setted as root 
	 * 						directly on the FXML TreeItem (in the GuiController.java).
	 *                     <p>
	 *                     Add one treeItemImp to each Paragraph object and anchor it in
	 *                     the root (treeItemNodeBase) of TreeView.
	 */
	public void createRelativesTreeItemsToParagraphsAndMakeTreeViewStructure(TreeItemImp<String> treeItemNodeBase) {
		docParagraphs.stream().forEach(paragraph -> {
			TreeItemImp<String> ti = new TreeItemImp<>(paragraph.getText());
			paragraph.setTreeItemImp(ti); // associate the treeItem of the Paragraph to the TreeItem ti created
			ti.setParagraph(paragraph);
			
			if (paragraph.getIndexOfParentInsideDocParagraphs() == indexUsedToReferThatTheParentOfOneParagraphIsTheDocument) {
				treeItemNodeBase.getChildren().add(paragraph.getTreeItemImp());
			} else {
				Paragraph parent = docParagraphs.get(paragraph.getIndexOfParentInsideDocParagraphs());
				parent.getTreeItemImp().getChildren().add(paragraph.getTreeItemImp()); // The parent is the parent variable
			}
		});
	}

	public void unmountLogbookSectionLines() {

		for (int i = 0; i < getDocParagraphs().size(); i++) { 
			if (getDocParagraphs().get(i).getText().startsWith(":LOGBOOK:")) {
				ClockReport clockReport = new ClockReport();
				getDocParagraphs().get(i).setClockReport(clockReport);
				Tools.setTheClockReportParent(clockReport, i, docParagraphs);
				Tools.setTheRegistryLinesClockReport(clockReport, i, docParagraphs);
			}
		}
	}

	public void specifyReferencialParametersForAllParagraphsInsideDocParagraph() {
		for (int u = docParagraphs.size() - 1; u >= 0; u--) {
			Paragraph paragraph = docParagraphs.get(u);
			paragraph.setIndexOfParentInsideDocParagraphs(indexUsedToReferThatTheParentOfOneParagraphIsTheDocument);
			paragraph.setLinePositionInsideDocParagraphsList(u); 
		}
	}

	public boolean isTheParagraphAboveParentOfTheBellowInTheTreeView(
		Paragraph paragraphBellowInTreeView, Paragraph paragraphAboveInTreeView) {
		
		boolean isCandidate =
				isParagraphAboveInTreeViewCandidateToBeParentOfTheParagraphBellow(
					 paragraphBellowInTreeView, paragraphAboveInTreeView);
		
		boolean result =
				((isCandidate)&&(isParagraphNotSimpleText(paragraphAboveInTreeView)))
					? true: false;
		
		return result;
	}
	
	public boolean isParagraphAboveInTreeViewCandidateToBeParentOfTheParagraphBellow(
	Paragraph paragraphBellowInTreeView, Paragraph paragraphAboveInTreeView) {
	
		boolean isCandidate =
			(paragraphAboveInTreeView.getNumberAsterisksParagraphBegins() <
				paragraphBellowInTreeView.getNumberAsterisksParagraphBegins())
		? true: false;
		
		return isCandidate;
	}

	public boolean isParagraphNotSimpleText(Paragraph paragraph) {
		// is not simple text (text beginning with "*")?
		return (paragraph.getNumberAsterisksParagraphBegins() != 0) ? true: false;
	}
	
	public boolean isParagraphSimpleText(Paragraph paragraph) {
		// is simple text (text not beginning with "*")?
		return (paragraph.getNumberAsterisksParagraphBegins() == 0) ? true: false;
	}
	
	public List<Paragraph> getDocParagraphs() {
		return docParagraphs;
	}

	public void setDocParagraphs(List<Paragraph> docParagraphs) {
		this.docParagraphs = docParagraphs;
	}

}
