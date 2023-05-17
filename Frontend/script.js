// Get the todo list and attach a click event listener to it
var todoList = document.querySelector('.todo-list');
todoList.addEventListener('click', function (event) {
	// Get the clicked element and its parent li element
	var clickedElement = event.target;
	var todoItem = clickedElement.parentElement;

	// Check which button was clicked
	if (clickedElement.classList.contains('edit-btn')) {
		// Toggle the edit mode
		toggleEditMode(todoItem);
	} else if (clickedElement.classList.contains('save-btn')) {
		// Save the changes and exit edit mode
		saveChanges(todoItem);
		toggleEditMode(todoItem);
	} else if (clickedElement.classList.contains('cancel-btn')) {
		// Discard the changes and exit edit mode
		cancelChanges(todoItem);
		toggleEditMode(todoItem);
	} else if (clickedElement.classList.contains('delete-btn')) {
		// Delete the todo item
		deleteTodoItem(todoItem);
	}
});

// Function to toggle the edit mode for a todo item
function toggleEditMode(todoItem) {
	// Get the relevant elements
	var taskNameElement = todoItem.querySelector('.task-name');
	var descriptionElement = todoItem.querySelector('.description');
	var statusElement = todoItem.querySelector('.status');
	var startDateElement = todoItem.querySelector('.start-date');
	var finishDateElement = todoItem.querySelector('.finish-date');
	var editBtn = todoItem.querySelector('.edit-btn');
	var saveBtn = todoItem.querySelector('.save-btn');
	var cancelBtn = todoItem.querySelector('.cancel-btn');
	var deleteBtn = todoItem.querySelector('.delete-btn');

	// Toggle the edit mode
	taskNameElement.contentEditable = !taskNameElement.isContentEditable;
	descriptionElement.contentEditable = !descriptionElement.isContentEditable;
	statusElement.contentEditable = !statusElement.isContentEditable;
	startDateElement.contentEditable = !startDateElement.isContentEditable;
	finishDateElement.contentEditable = !finishDateElement.isContentEditable;
	editBtn.style.display = editBtn.style.display === 'none' ? 'inline-block' : 'none';
	saveBtn.style.display = saveBtn.style.display === 'none' ? 'inline-block' : 'none';
	cancelBtn.style.display = cancelBtn.style.display === 'none' ? 'inline-block' : 'none';
	deleteBtn.style.display = deleteBtn.style.display === 'none' ? 'inline-block' : 'none';
}

// Function to save the changes made to a todo item
function saveChanges(todoItem) {
	// Get the relevant elements
	var taskNameElement = todoItem.querySelector('.task-name');
	var descriptionElement = todoItem.querySelector('.description');
	var statusElement = todoItem.querySelector('.status');
	var startDateElement = todoItem.querySelector('.start-date');
	var finishDateElement = todoItem.querySelector('.finish-date');

	// Update the todo item with the new values
	taskNameElement.textContent = taskNameElement.textContent.trim();
	descriptionElement.textContent = descriptionElement.textContent.trim();
	statusElement.textContent = statusElement.textContent.trim();
	startDateElement.textContent = startDateElement.textContent.trim();
	finishDateElement.textContent = finishDateElement.textContent.trim();

	// Update the status class based on the selected status value
	statusElement.classList.remove('not-started', 'in-progress', 'completed');
	statusElement.classList.add(statusElement.textContent.toLowerCase().replace(' ', '-'));

	// Show a success message
	alert('Changes saved successfully.');
}

// Function to discard the changes made to a todo item
function cancelChanges(todoItem) {
	// Get the relevant elements
	var taskNameElement = todoItem.querySelector('.task-name');
	var descriptionElement = todoItem.querySelector('.description');
	var statusElement = todoItem.querySelector('.status');
	var startDateElement = todoItem.querySelector('.start-date');
	var finishDateElement = todoItem.querySelector('.finish-date');

	// Revert the changes made to the todo item
	taskNameElement.textContent = taskNameElement.dataset.originalValue;
	descriptionElement.textContent = descriptionElement.dataset.originalValue;
	statusElement.textContent = statusElement.dataset.originalValue;
	startDateElement.textContent = startDateElement.dataset.originalValue;
	finishDateElement.textContent = finishDateElement.dataset.originalValue;

	// Update the status class based on the selected status value
	statusElement.classList.remove('not-started', 'in-progress', 'completed');
	statusElement.classList.add(statusElement.dataset.originalStatus);

	// Show a success message
	alert('Changes discarded successfully.');
}

// Function to delete a todo item
function deleteTodoItem(todoItem) {
	// Remove the todo item from the todo list
	todoItem.remove();

	// Show a success message
	alert('Todo item deleted successfully.');
}