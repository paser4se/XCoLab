<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:collab="http://climatecolab.org/tags/collab_1.0"
	xmlns:modeling="urn:jsptagdir:/WEB-INF/tags/modeling"
	xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">
    <jsp:directive.include file="./header.jsp"/>
    <h2>Groups:</h2>
    
	<portlet:actionURL var="updateGroupsUrl">
		<portlet:param name="action" value="addUpdateInputGroup"/>
		<portlet:param name="tab" value="inputTabs" />
		<portlet:param name="modelId" value="${model.id }" />
	</portlet:actionURL>
	<h1>${modelDisplay.groups }</h1>
	<form:form commandName="updateModelInputGroupBean" role="form" action="${updateGroupsUrl }">
		<form:hidden path="inputAction" id="addUpdateGroupAction" />
    <table class="table table-striped">
    	<thead>
    		<tr>
    			<th>Id</th>
    			<th>Copy name/description from input</th>
    			<th>Name</th>
    			<th>Description</th>
    			<th>Parent group</th>
    			<th>Type</th>
    			<th>Order</th>
    			<th>Action</th>
    		</tr>
    	</thead>
    	<tbody>
    	
    		<tr id="addEditGroupInputs">
    			<td class="id"><form:input type="text" value="0" class="hidden input" path="id"/><!--  --></td>
    			<td>    				
    				<form:select class="input" items="${individualInputsById}" path="nameDescriptionMetaDataId" />
    			</td>
    			<td class="form-group name">
    				<form:input type="text"  path="name" class="input form-control" value="${inputGroup.name }" />
    			</td>
    			<td class="description">
    				<form:textarea path="description" value="${inputGroup.description }" class="input"/>
    			</td>
    			<td class="parentGroup">
    				<form:select items="${groupInputsById }" path="parentGroupPK" class="input" />
    			</td>
    			<td class="type">
    				<form:select path="groupType" class='input'>
    					<option value="TAB">TAB</option>
    					<option value="HORIZONTAL">HORIZONTAL</option>
    				</form:select>
    			</td>
    			<td class="order">
    				<form:input type="text" path="order" value="${inputGroup.displayItemOrder }" class="input" />
				</td>
				<td>
					<button class="btn btn-primary">Save</button>
					<button class="btn btn-default">Cancel</button>
				</td>
    			
    		</tr>
    	
    	<c:forEach var="inputGroup" items="${groupsAndTabs}">
    		<tr>
    			<td class='id'>${inputGroup.groupId }</td>
    			<td class="nameDescriptionMetaDataId">    				<!--  -->
    			</td>
    			<td class="name">
    				${inputGroup.name }
    			</td>
    			<td class="description">
    				${inputGroup.description }
    			</td>
    			<td class="parentGroup">
    				${inputGroup.parentGroupId }
    			</td>
    			<td class="type">
    				${inputGroup.groupType }
    			</td>
    			<td class="order">
    				${inputGroup.order }
				</td>
				<td>
					<button class="btn btn-info editGroupTrigger">Edit</button>
					<button class="btn btn-info deleteGroupTrigger">Delete</button>
				</td>
			</tr>
    	</c:forEach>
      </tbody>
    </table>
    </form:form>
    
    
    
    
    <h2>Individual:</h2>
	<portlet:actionURL var="udateIndividualInputGroupUrl">
		<portlet:param name="action" value="udateIndividualInputGroup"/>
		<portlet:param name="tab" value="inputTabs" />
		<portlet:param name="modelId" value="${model.id }" />
	</portlet:actionURL>
    <table class="table table-striped">
    	<thead>
    		<tr>
    			<td>Name</td>
    			<td>Description</td>
    			<td>GroupId</td>
    			<td>Order</td>
    			<td>Action</td>
    		</tr>
    	</thead>
    	<c:forEach var="input" items="${modelDisplay.allIndividualInputs}">
    		<form:form action="${udateIndividualInputGroupUrl }" commandName="udateIndividualInputGroupBean">
    			<form:hidden path="modelInputItemId" value="${input.metaData.id }"/>
    			<tr>
    				<td>${input.name }</td>
    				<td>${input.description }</td>
    				<td><form:select path="groupId" items="${groupInputsById }" data-value="${input.groupId }" class="individualInputGroup" /></td>
    				<td><form:input type="text" path="order" /></td>
    				<td><input type="submit" class="btn btn-default" value="Save" /></td>
    			</tr>
    		</form:form>
    	</c:forEach>
    </table>
    

<script>
	function populateEditGroupWidget(trigger) {
		var trriggerParentRow = trigger.parents("tr");
		var editWidget = $("#addEditGroupInputs");
		
		trriggerParentRow.find("td").each(function() {
			var col = $(this);
			var clasz = col.attr('class');
			var input = editWidget.find("td." + clasz + " .input");
			editWidget.find("td." + clasz + " .input").val($.trim(col.text()));
			
		});
	}
	
	$(".editGroupTrigger").click(function(event ) {
		event.preventDefault();
		var trigger = $(this);
		trriggerParentRow = trigger.parents("tr");
		populateEditGroupWidget(trigger);
		var editWidget = $("#addEditGroupInputs");

		editWidget.insertAfter(trriggerParentRow);
		editWidget.show();
		$("#addUpdateGroupAction").val("update");
		
		return false;
	});

	$(".deleteGroupTrigger").click(function(event ) {
		var trigger = $(this);
		populateEditGroupWidget(trigger);
		var editWidget = $("#addEditGroupInputs");

		//editWidget.insertAfter(trriggerParentRow);
		$("#addUpdateGroupAction").val("delete");
		if (confirm("Are you sure you want to delete selected group?")) {
			// just let the form be submitted
		}
		else {
			event.preventDefault();
			return false;
		}
	});
	
	$("select.individualInputGroup").each(function() {
		var select = $(this);
		var value = select.attr('data-value');
		console.log("setting value:", select, value);
		select.val(value);
		
	});
</script>
</jsp:root>