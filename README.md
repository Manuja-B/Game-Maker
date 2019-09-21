# Team2-Week4
Follow the steps during development:
1. **Please get the latest code from master before starting development**. This can be done by the following command.   `git pull`
2. When starting work on a new feature, branch off from the current branch to name of the jira sub-task/task you're working on.  
`$ git checkout -b <branch-name> `
3. Once you're done with your changes, see the status of your local repository with `git status`.
4.  Check if your changed files are in the list of tracked files. Check if **only** your changed files  are in the list of tracked files. If any file you changed is untracked, add it with `git add <filename>`.(without dot)  
If any file is not changed, but is in the list of tracked files, remove it with `git reset <filename>`
To add all untracked files , do `git add .`(the dot is important)
5. Once you're satisfied with the list of modified and tracked files, go ahead and commit it to the local repository with the following command.  
` git commit -m <message in double quotes>`  
6. Now push the changes to remote branch in git by the following command.  
`git push origin <branch-name>`
