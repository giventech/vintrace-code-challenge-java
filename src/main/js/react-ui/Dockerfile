#Pull docker images to build React App
FROM node:13.12.0-alpine as development
WORKDIR /usr/src/app 



ENV PATH /usr/src/app/node_modules/.bin:$PATH


COPY ./package.json ./
COPY ./package-lock.json ./
RUN npm install 
RUN npm install react-scripts@latest -g 

COPY . .

# start app
CMD ["npm", "start"]

#Package the application to serve the app
FROM nginx:1.12-alpine
COPY --from=development /usr/src/app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]